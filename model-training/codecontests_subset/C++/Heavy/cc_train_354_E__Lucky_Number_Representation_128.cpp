#include <bits/stdc++.h>
using namespace std;
int fs[43][2], d[20], dp[20][10], r[20][10], from[20][10];
vector<int> pos;
int main() {
  memset((fs), -1, sizeof((fs)));
  for (int i = 0; i <= 6; i++)
    for (int j = 0; i + j <= 6; j++) {
      fs[i * 7 + j * 4][0] = i;
      fs[i * 7 + j * 4][1] = j;
    }
  for (int i = 0; i <= 42; i++) {
    if (fs[i][0] != -1) pos.push_back(i);
  }
  int ___T, case_n = 1;
  scanf("%d ", &___T);
  while (___T-- > 0) {
    long long n;
    cin >> n;
    for (int i = 0; i < 20; i++) {
      d[i] = n % 10;
      n /= 10;
    }
    memset((dp), -1, sizeof((dp)));
    memset((r), 0, sizeof((r)));
    dp[0][0] = 0;
    for (int i = 0; i < 19; i++) {
      for (int j = 0; j < 10; j++) {
        if (dp[i][j] != -1) {
          for (int k = 0; k < ((int)(pos).size()); k++) {
            if (pos[k] % 10 == (d[i] - j + 100) % 10) {
              dp[i + 1][(j + pos[k]) / 10] = k;
              from[i + 1][(j + pos[k]) / 10] = j;
            }
          }
        }
      }
    }
    if (dp[19][0] != -1) {
      int x = 19, y = 0;
      while (x) {
        int v = pos[dp[x][y]];
        int cnt = 0;
        for (int i = 0; i < fs[v][0]; i++) r[x - 1][cnt++] = 7;
        for (int i = 0; i < fs[v][1]; i++) r[x - 1][cnt++] = 4;
        y = from[x][y];
        x--;
      }
      for (int i = 0; i < 6; i++) {
        long long tmp = 0;
        for (int j = 18; j >= 0; j--) tmp = tmp * 10 + r[j][i];
        if (i) printf(" ");
        cout << tmp;
      }
      puts("");
    } else
      puts("-1");
  }
  return 0;
}
