#include <bits/stdc++.h>
using namespace std;
long long arr[5], cnt;
string s;
int main() {
  cin >> s;
  for (long long i = 0; i < s.length(); i++) {
    if (s[i] == '1') {
      arr[1]++;
      cnt++;
    }
    if (s[i] == '2') {
      arr[2]++;
      cnt++;
    }
    if (s[i] == '3') {
      arr[3]++;
      cnt++;
    }
  }
  for (long long i = 0; i < cnt; i++) {
    if (arr[1] > 0) {
      arr[1]--;
      cout << 1;
    } else if (arr[2] > 0) {
      cout << 2;
      arr[2]--;
    } else if (arr[3] > 0) {
      cout << 3;
      arr[3]--;
    }
    if (i == cnt - 1) {
      cout << endl;
    } else {
      cout << '+';
    }
  }
}
