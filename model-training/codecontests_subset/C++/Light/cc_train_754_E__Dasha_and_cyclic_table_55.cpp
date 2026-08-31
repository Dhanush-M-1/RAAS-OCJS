#include <bits/stdc++.h>
using namespace std;
const int ALPHABETS = 30;
const int maxN = 410;
bitset<maxN> orig[ALPHABETS][maxN], ans[maxN];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int N, M;
  cin >> N >> M;
  string s;
  for (int i = 0; i < N; i++) {
    cin >> s;
    for (int j = 0; j < M; j++) {
      orig[s[j] - 'a'][i][j] = true;
      ans[i][j] = true;
    }
  }
  int R, C;
  cin >> R >> C;
  for (int i = 0; i < R; i++) {
    cin >> s;
    for (int j = 0; j < C; j++) {
      if (s[j] == '?') continue;
      char ch = s[j] - 'a';
      int goForward = j % M;
      for (int k = 0; k < N; k++) {
        int origR = (((k - i) % N) + N) % N;
        ans[origR] &=
            (orig[ch][k] >> goForward) | (orig[ch][k] << (M - goForward));
      }
    }
  }
  for (int i = 0; i < N; i++) {
    for (int j = 0; j < M; j++) {
      if (ans[i][j])
        cout << "1";
      else
        cout << "0";
    }
    cout << "\n";
  }
  return 0;
}
