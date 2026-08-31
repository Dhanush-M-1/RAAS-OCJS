#include <bits/stdc++.h>
using namespace std;
const int N = int(1e5 + 3);
int a[26];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int k;
  cin >> k;
  char first;
  int c = 0;
  while (cin >> first) {
    a[first - 'a']++;
    c++;
  }
  string second = "";
  for (int i = 0; i < 26; i += 1) {
    if (!(a[i] % k == 0)) {
      puts("-1");
      return 0;
    }
  }
  for (int i = 0; i < 26; i += 1)
    if (a[i])
      for (int j = 0; j < a[i] / k; j += 1) second += (char)(i + 97);
  for (int i = 0; i < c; i += second.size()) cout << second;
  return 0;
}
