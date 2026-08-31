#include <bits/stdc++.h>
const int OO = 0x3f3f3f3f;
using namespace std;
void Play();
int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  for (int i = 1; i < s.size(); ++i) {
    if (s[i] < s[i - 1]) {
      cout << "YES" << endl;
      cout << i << " " << i + 1 << endl;
      return 0;
    }
  }
  cout << "NO" << endl;
  return 0;
}
void Play() { ios::sync_with_stdio(false), cin.tie(0), cout.tie(0); }
