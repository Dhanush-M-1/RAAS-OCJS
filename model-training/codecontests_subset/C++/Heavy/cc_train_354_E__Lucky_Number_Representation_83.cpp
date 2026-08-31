#include <bits/stdc++.h>
using namespace std;
int n, A[20], m, B[7], s, ant[20][7];
long long first, res[7];
bool marc[43], valid[20][7];
vector<int> sol[43];
void back(int k) {
  if (k == 7) {
    if (!marc[s]) {
      marc[s] = true;
      for (int i = 1; i <= 6; i++) sol[s].push_back(B[i]);
    }
    return;
  }
  B[k] = 0;
  back(k + 1);
  B[k] = 4;
  s += 4;
  back(k + 1);
  s -= 4;
  B[k] = 7;
  s += 7;
  back(k + 1);
  s -= 7;
}
void precompute() { back(1); }
void recons(int digit, int trans) {
  if (digit == 0) return;
  int i, val = ant[digit][trans];
  for (i = 0; i < 6; i++) res[i + 1] = res[i + 1] * 10 + sol[val][i];
  recons(digit - 1, 10 * trans + A[digit] - val);
}
int main() {
  precompute();
  cin >> n;
  int i, j, k, t, val;
  for (i = 1; i <= n; i++) {
    cin >> first;
    while (first) {
      A[++m] = first % 10;
      first /= 10;
    }
    for (k = 0; k <= 4; k++) {
      val = k * 10 + A[1];
      if (val <= 42 && marc[val]) {
        valid[1][val / 10] = true;
        ant[1][val / 10] = val;
      }
    }
    for (j = 2; j <= m; j++)
      for (k = 0; k <= 4; k++) {
        val = k * 10 + A[j];
        if (val <= 46) {
          for (t = 0; t <= 4; t++)
            if (valid[j - 1][t] && val - t <= 42 && marc[val - t]) {
              valid[j][k] = true;
              ant[j][k] = val - t;
            }
        }
      }
    if (!valid[m][0])
      printf("-1\n");
    else {
      recons(m, 0);
      for (j = 1; j < 6; j++) cout << res[j] << " ";
      cout << res[6] << "\n";
    }
    m = 0;
    memset(valid, false, sizeof(valid));
    memset(ant, 0, sizeof(ant));
    memset(res, 0, sizeof(res));
  }
  return 0;
}
