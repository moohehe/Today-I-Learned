package com.example.scitmaster.tiktaktok;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView msgBox;
    Button[][] btn_array;
    Button startBtn;
    private final static int GAME_WIDTH=9;
    private final static int GAME_HEIGHT=8;
    private final static int GAME_WIN = 5;
    int player;
    int[][] map = new int[GAME_WIDTH][GAME_HEIGHT];
    boolean endGame = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 게임 스테이지 타일 갯수 설정 GAME_WIDTH X GAME_HEIGHT
        btn_array = new Button[GAME_WIDTH][GAME_HEIGHT];
        System.out.println("array.length="+btn_array.length);
        System.out.println("array[0].length="+btn_array[0].length);
        // 객체 할당
        msgBox = findViewById(R.id.msgBox);
        startBtn = findViewById(R.id.startBtn);
        for(int i = 0; i <GAME_WIDTH; i++) {
            for (int j = 0; j<GAME_HEIGHT; j++) {
                System.out.println("i="+i+" j="+j);
                String name = "p"+i+j;
                int id = getResources().getIdentifier(name,"id",getPackageName());
                btn_array[i][j] = findViewById(id);
                //System.out.println("btn_array["+i+"]["+j+"]="+btn_array[i][j]);
                btn_array[i][j].setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        //String text = ((Button) view).getText().toString();
                        //Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                        calc_game(view);
                    }
                });
            }
        }
        player = 1; // 플레이어 1로 초기화

    }

    private void calc_game(View view) {
        //게임이 끝났는지 확인
        if (endGame)
            return;

        int color;
        color = player == 1 ? Color.WHITE : Color.LTGRAY;
        // 0. 게임 재시작 버튼인지 검사
        // 1. 어느곳을 클릭한건지 검사 -> 비어있으면 Player1: O / Player2: X 입력
        // 1-1. 좌표 받기
        int x = 0;
        int y = 0;
        for (int j = 0; j<GAME_HEIGHT;j++) {
            for (int i = 0; i<GAME_WIDTH;i++) {
                String name = "p"+i+j;
                int id = getResources().getIdentifier(name,"id",getPackageName());
                if (id == view.getId()) {
                    x = i;  y = j;
                    break;
                }
            }
        }

        // 1-2. 비어있지 않으면 종료
          if (map[x][y] != 0)
          {
              return;
          }
        // 2. 누구의 차례인지 검사
        if (player == 1)
        {
            // 자리 차지하기
            ((Button) view).setText("O");
            ((Button) view).setTextColor(Color.BLUE);
            // 맵 기록
            map[x][y]=1;
            // 플레이어 변경
            player = 2;
        }
        else if (player == 2)
        {
            ((Button) view).setText("X");
            ((Button) view).setTextColor(Color.RED);
            map[x][y]=2;
            player = 1;
        }
        // 2.2 차례 넘기기 메세지 출력
        String message = "player "+player+"님의 차례입니다.";
        msgBox.setText(message);
        // 2.3 색깔 바꾸기
        msgBox.setBackgroundColor(color);

        // 3. 가로/세로/대각선 3줄인지 검사-> 3줄이면 확인
        // 3-1. 가로 승리조건 검사
        for(int p=1;p<3;p++) {//플레이어 두명 검사
            for (int i = 0; i < GAME_WIDTH; i++) {
                int w_win = 0; // 가로 승리조건 검사
                for (int j = 0; j < GAME_HEIGHT; j++) {
                    if (map[i][j]==p){
                        w_win++;
                    // 승리조건 검사
                        if (w_win == GAME_WIN) {
                            endOfGame(p);
                            return;
                        }
                    }
                    else // 처음부터 다시 센다
                        w_win = 0;
                }
            }
        }
        // 3.2 세로 승리조건 검사
        for(int p=1;p<3;p++) {//플레이어 두명 검사
            for (int j = 0; j < GAME_HEIGHT; j++) {
                int h_win = 0; // 세로 승리조건 검사
                for (int i = 0; i < GAME_WIDTH; i++) {
                    if (map[i][j]==p) {
                        h_win++;
                        // 승리조건 검사
                        if (h_win == GAME_WIN) {
                            endOfGame(p);
                            return;
                        }
                    }
                    else //처음부터 다시 센다
                        h_win = 0;
                }
            }
        }
        // 대각선 검사
        for (int p = 1; p< 3;p++) {// p == 1 이거나 p == 2 일때

            //  대각선검사1. 우측 아래 대각선 검사
            for (int i = 0; i<GAME_WIDTH;i++) {
                for (int j = 0; j<GAME_HEIGHT;j++) {
                    if (map[i][j] == 0) continue;

                    // 1. 오른쪽 가로에 공간이 있는지 먼저 확인
                    // 2. 있으면 세로에 공간이 있는지 확인 -> 없으면 continue; 다음검사
                    // 3. 있으면 GAME_WIN 조건만큼 x++, y++ 하면서 검사한다.
                    if (GAME_WIN > ( GAME_WIDTH - j-1) ) break;
                    if (GAME_WIN > (GAME_HEIGHT - i) ) break;
                    int d_win = 0;
                    for (int l = 0; l< GAME_WIN; l++) {
                        System.out.println("aa map["+(i+l)+"]["+(j+l)+"]="+map[i+l][j+l] + "  p="+p+" l="+l);
                        if ( map[i+l][j+l] == p) {
                            d_win++;

                            if (d_win == GAME_WIN) {
                                endOfGame(p);
                                return;
                            }
                        }
                        else
                            break;
                    }
                }
            }

            //  대각선검사2. 좌측 아래 대각선 검사
            for (int i = 0; i<GAME_WIDTH;i++) {
                for (int j = 0; j<(GAME_HEIGHT); j++) {
                    if (map[i][j] == 0) continue;

                    // 1. 왼쪽으로 공간이 있는지 확인
                    // 2. 아래로 공간이 있는지 확인 -> 없으면 continue; 다음검사
                    // 3. 공간이 있으면 GAME_WIN 조건만큼 x--, y-- 하면서 검사한다.
                    System.out.println("i="+i+" j="+j);
                    System.out.println("GAME_WIN="+GAME_WIN + " i+1="+(i+1)+" GAME_WIDTH - j="+(GAME_HEIGHT -j));
                    if (GAME_WIN > (i+1)) continue;

                    if (GAME_WIN > (GAME_HEIGHT - j-1)  ) break;
                    int d_win = 0; // 몇개 연속인지 세는 변수

                    System.out.println("뾰로롱47");
                    for (int l = 0; l< GAME_WIN; l++) {
                        System.out.println("bb map["+(i-l)+"]["+(j+l)+"]="+map[i-l][j+l] + "  p="+p);
                        if ( map[i-l][j+l] == p) {
                            d_win++;
                            System.out.println("d_win="+d_win);
                            if (d_win == GAME_WIN) {
                                endOfGame(p);
                                return;
                            }
                        }
                        else
                            break;
                    }
                }
            }

        }


            // 아직 승부가 나지 않은 경우
        // 4. 클릭할 곳이 남아있는지 검사 -> 없으면 무승부 처리
        // 4-1. 빈곳이 있는지 검사(empty)
        boolean empty = true;
        for (int i=0; i<GAME_WIDTH;i++)
        {
            for (int j=0;j<GAME_HEIGHT;j++)
            {
                if (map[i][j] == 0)
                {
                    empty = false;
                    return;
                }
            }
        }
        // 4-2. 빈곳이 없으면 무승부 처리
        if (empty)
        {
            endOfGame(0);
            return;
        }
    }

    // 게임이 끝날때
    public void endOfGame(int player){
        String message;
        // 이긴 플레이어가 없을때(무승부 : player==0)
        if (player == 0) {
            message = "무승부입니다.";
        }
        else { // 이긴 플레이어가 있을때
            message = "Player"+player+"님이 이기셨습니다.";
        }
        //print message
        msgBox.setText(message);
        //버튼 전부 잠그기
        endGame = true;
    }

    /**
     * restart Btn
     */
    public void reStart(View view) {
        // map 초기화
        map = new int[GAME_WIDTH][GAME_HEIGHT];
        // 글자 초기화
        int n = 1;
        for(int i = 0; i<GAME_WIDTH; i++) {
            for(int j=0;j<GAME_HEIGHT;j++) {
                //btn_array[i][j].setText(String.valueOf(n));
                //n++;
                btn_array[i][j].setText("");
            }
        }
        // Player 초기화
        player = 1;
        // message 초기화
        String message = "Player1 님의 차례입니다.";
        msgBox.setText(message);
        endGame = false;
    }
}
