#include <bits/stdc++.h>
using namespace std;
const int maxint = -1u >> 1;
template <class T>
bool get_max(T& a, const T& b) {
  return b > a ? a = b, 1 : 0;
}
template <class T>
bool get_min(T& a, const T& b) {
  return b < a ? a = b, 1 : 0;
}
int k;
int num[26];
string s;
int main() {
  cin >> k;
  cin >> s;
  memset(num, 0, sizeof(num));
  for (int i = 0; i < s.size(); i++) num[s[i] - 'a']++;
  int flag = 1;
  for (int i = 0; i < 26; i++)
    if (num[i] % k != 0) {
      flag = 0;
    }
  if (flag == 0)
    puts("-1");
  else {
    string ans;
    for (int i = 0; i < k; i++)
      for (int j = 0; j < 26; j++)
        for (int g = 0; g < num[j] / k; g++) {
          ans = ans + char(j + 'a');
        }
    cout << ans << endl;
  }
  return 0;
}
