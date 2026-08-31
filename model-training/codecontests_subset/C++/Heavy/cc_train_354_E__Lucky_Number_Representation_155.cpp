#include <bits/stdc++.h>
using namespace std;
const int N_MAX = 20;
int t;
int n;
int digits[N_MAX];
int lucky[] = {0, 4, 7};
bool dp[N_MAX][5];
tuple<int, int, int, int, int, int> step[N_MAX][5];
int prevt[N_MAX][5];
long long ans[7];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> t;
  while (t--) {
    long long val;
    cin >> val;
    n = 0;
    while (val > 0) {
      digits[++n] = val % 10;
      val /= 10;
    }
    for (int i = 0; i <= n; i++)
      for (int t = 0; t <= 4; t++) dp[i][t] = false;
    dp[0][0] = true;
    for (int i = 0; i < n; i++)
      for (int t = 0; t <= 4; t++)
        if (dp[i][t] == true) {
          for (int a = 0; a < 3; a++)
            for (int b = a; b < 3; b++)
              for (int c = b; c < 3; c++)
                for (int d = c; d < 3; d++)
                  for (int e = d; e < 3; e++)
                    for (int f = e; f < 3; f++) {
                      int sum = lucky[a] + lucky[b] + lucky[c] + lucky[d] +
                                lucky[e] + lucky[f] + t;
                      if (sum % 10 == digits[i + 1]) {
                        dp[i + 1][sum / 10] = true;
                        step[i + 1][sum / 10] = make_tuple(a, b, c, d, e, f);
                        prevt[i + 1][sum / 10] = t;
                      }
                    }
        }
    if (dp[n][0] == true) {
      long long p10 = 1;
      for (int i = 1; i < n; i++) p10 *= 10;
      for (int i = 1; i <= 6; i++) ans[i] = 0;
      int pos = n;
      int t = 0;
      while (pos > 0) {
        int a, b, c, d, e, f;
        tie(a, b, c, d, e, f) = step[pos][t];
        ans[1] += lucky[a] * p10;
        ans[2] += lucky[b] * p10;
        ans[3] += lucky[c] * p10;
        ans[4] += lucky[d] * p10;
        ans[5] += lucky[e] * p10;
        ans[6] += lucky[f] * p10;
        p10 /= 10;
        t = prevt[pos][t];
        pos--;
      }
      for (int i = 1; i <= 6; i++) cout << ans[i] << " ";
      cout << "\n";
    } else
      cout << "-1\n";
  }
  return 0;
}
