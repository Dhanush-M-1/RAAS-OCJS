#include <bits/stdc++.h>
using namespace std;
int main(){
  while (1){
    int N;
    cin >> N;
    if (N == 0){
      break;
    }
    vector<vector<vector<int>>> A(N, vector<vector<int>>(4, vector<int>(4)));
    for (int i = 0; i < N; i++){
      for (int j = 0; j < 4; j++){
        for (int k = 0; k < 4; k++){
          cin >> A[i][j][k];
        }
      }
    }
    vector<vector<vector<bool>>> ok(N, vector<vector<bool>>(3, vector<bool>(3, true)));
    for (int i = 0; i < N; i++){
      for (int j = 0; j < 3; j++){
        for (int k = 0; k < 3; k++){
          for (int l = 0; l < 2; l++){
            for (int m = 0; m < 2; m++){
              if (A[i][j + l][k + m] == 1){
                ok[i][j][k] = false;
              }
            }
          }
        }
      }
    }
    vector<vector<vector<vector<vector<vector<vector<bool>>>>>>> dp(N, vector<vector<vector<vector<vector<vector<bool>>>>>>(3, vector<vector<vector<vector<vector<bool>>>>>(3, vector<vector<vector<vector<bool>>>>(7, vector<vector<vector<bool>>>(7, vector<vector<bool>>(7, vector<bool>(7, false)))))));
    if (ok[0][1][1]){
      dp[0][1][1][1][1][1][1] = true;
    }
    for (int i = 0; i < N - 1; i++){
      for (int j = 0; j < 3; j++){
        for (int k = 0; k < 3; k++){
          for (int l = 0; l < 7; l++){
            for (int m = 0; m < 7; m++){
              for (int n = 0; n < 7; n++){
                for (int o = 0; o < 7; o++){
                  if (dp[i][j][k][l][m][n][o]){
                    for (int p = 0; p < 3; p++){
                      for (int q = 0; q < 3; q++){
                        if (j == p || k == q){
                          if (ok[i + 1][p][q]){
                            int l2 = l + 1;
                            int m2 = m + 1;
                            int n2 = n + 1;
                            int o2 = o + 1;
                            if (p == 0 && q == 0){
                              l2 = 0;
                            }
                            if (p == 0 && q == 2){
                              m2 = 0;
                            }
                            if (p == 2 && q == 0){
                              n2 = 0;
                            }
                            if (p == 2 && q == 2){
                              o2 = 0;
                            }
                            if (l2 < 7 && m2 < 7 && n2 < 7 && o2 < 7){
                              dp[i + 1][p][q][l2][m2][n2][o2] = true;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    bool ans = false;
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
        for (int k = 0; k < 7; k++){
          for (int l = 0; l < 7; l++){
            for (int m = 0; m < 7; m++){
              for (int n = 0; n < 7; n++){
                if (dp[N - 1][i][j][k][l][m][n]){
                  ans = true;
                }
              }
            }
          }
        }
      }
    }
    if (ans){
      cout << 1 << endl;
    } else {
      cout << 0 << endl;
    }
  }
}
