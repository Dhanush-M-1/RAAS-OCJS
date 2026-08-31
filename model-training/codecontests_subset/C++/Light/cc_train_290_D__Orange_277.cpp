#include <bits/stdc++.h>
using namespace std;
int main() {
  string S;
  cin >> S;
  int M;
  cin >> M;
  for (int i = 0; i < S.length(); i++) {
    char ch = S[i];
    if (ch - 'Z' <= 0) ch -= ('A' - 'a');
    if (ch - 'a' < M)
      S[i] = ch + ('A' - 'a');
    else
      S[i] = ch;
  }
  cout << S << endl;
  return 0;
}
