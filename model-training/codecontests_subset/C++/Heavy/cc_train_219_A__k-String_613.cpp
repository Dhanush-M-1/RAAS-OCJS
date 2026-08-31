#include <bits/stdc++.h>
using namespace std;
int num(char c, char a[], int k) {
  int count = 0;
  for (int i = 0; i < k; i++) {
    if (a[i] == c) count++;
  }
  return count;
}
int main() {
  int n;
  bool check = true;
  cin >> n;
  string s, ans;
  cin >> s;
  int k = s.length();
  char c[k];
  for (int i = 0; i < k; i++) c[i] = s[i];
  set<char> a(begin(s), end(s));
  for (set<char>::iterator itr = a.begin(); itr != a.end(); ++itr) {
    if (num(*itr, c, k) % n != 0) {
      check = false;
      break;
    }
    int p = num(*itr, c, k) / n;
    string g(1, *itr);
    for (int l = 0; l < p; l++) ans.append(g);
  }
  string f;
  if (check) {
    for (int i = 0; i < n; i++) f.append(ans);
    cout << f;
  } else
    cout << -1;
}
