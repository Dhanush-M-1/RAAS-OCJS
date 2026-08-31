#include <bits/stdc++.h>
using namespace std;
const int NMax = 10005;
int T;
long long N;
pair<int, int> DP[6][25];
int dig[] = {0, 4, 7};
vector<int> V[NMax];
int x[20];
int Sum[NMax];
int cnt;
char Str[20];
long long Res[20];
void Fill(int poz) {
  for (int i = 1; i <= 6; i++) {
    V[poz].push_back(x[i]);
    Sum[poz] += x[i];
  }
}
void back(int k) {
  for (int i = 0; i < 3; i++) {
    x[k] = dig[i];
    if (k == 6) {
      Fill(++cnt);
    }
    if (k < 6) back(k + 1);
  }
}
void Print(int N) {
  if (DP[0][N] == make_pair(-1, -1)) {
    cout << "-1\n";
    return;
  }
  for (int i = 1; i <= 6; i++) Res[i] = 0;
  int j = N, f = 0;
  while (j > 0) {
    for (int i = 0; i < 6; i++)
      Res[i + 1] = Res[i + 1] * 10 + V[DP[f][j].second][i];
    int auxF = f;
    f = DP[auxF][j].first;
    j--;
  }
  for (int i = 1; i <= 6; i++) cout << Res[i] << " ";
  cout << "\n";
}
void Solve() {
  int N = strlen(Str + 1);
  for (int i = 0; i <= 4; i++)
    for (int j = 0; j <= 18; j++) DP[i][j] = make_pair(-1, -1);
  DP[0][0] = make_pair(0, 0);
  for (int j = 0; j < N; j++)
    for (int i = 0; i <= 4; i++) {
      if (DP[i][j] == make_pair(-1, -1)) continue;
      for (int k = 1; k <= cnt; k++) {
        if ((Sum[k] + i) % 10 == Str[j + 1] - '0') {
          DP[(Sum[k] + i) / 10][j + 1] = make_pair(i, k);
        }
      }
    }
  Print(N);
}
int main() {
  int T;
  cin >> T;
  cin.get();
  back(1);
  while (T--) {
    cin.getline(Str + 1, 25);
    int N = strlen(Str + 1);
    reverse(Str + 1, Str + N + 1);
    Solve();
  }
  return 0;
}
