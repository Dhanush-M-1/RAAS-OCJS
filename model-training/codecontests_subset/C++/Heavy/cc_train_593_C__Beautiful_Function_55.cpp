#include <bits/stdc++.h>
using namespace std;
int N;
int X[100][2], R[100];
string S[100][2];
string hoge(int i, int x) {
  char h[1010];
  sprintf(
      h,
      "(%d*((((0-abs((t-%d)))-abs((t-%d)))+abs(((t-%d)-1)))+abs(((t-%d)+1))))",
      x, i, i, i, i);
  return string(h);
}
void solve() {
  int i, j, k, l, r, x, y;
  string s;
  cin >> N;
  for (i = 0; i < N; i++) cin >> X[i][0] >> X[i][1] >> R[i];
  for (j = 0; j < 2; j++) {
    for (i = 0; i < N; i++) S[i][j] = hoge(i, X[i][j] / 2);
    s = S[0][j];
    for (i = 1; i < N; i++) s = "(" + s + "+" + S[i][j] + ")";
    cout << s << endl;
  }
}
int main(int argc, char** argv) {
  string s;
  int i;
  if (argc == 1) ios::sync_with_stdio(false);
  for (i = 0; i < argc - 1; i++) s += argv[i + 1], s += '\n';
  for (i = 0; i < s.size(); i++) ungetc(s[s.size() - 1 - i], stdin);
  solve();
  return 0;
}
