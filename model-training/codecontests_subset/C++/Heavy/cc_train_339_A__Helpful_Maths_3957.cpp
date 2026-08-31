#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  long long sl = s.length();
  long long one = 0;
  long long two = 0;
  long long three = 0;
  long long i;
  for (i = 0; i < sl; i = i + 2) {
    if (s[i] - '0' == 1) {
      one++;
    } else if (s[i] - '0' == 2) {
      two++;
    } else {
      three++;
    }
  }
  vector<char> v;
  for (i = 0; i < one; i++) {
    v.push_back('1');
    v.push_back('+');
  }
  for (i = 0; i < two; i++) {
    v.push_back('2');
    v.push_back('+');
  }
  for (i = 0; i < three; i++) {
    v.push_back('3');
    v.push_back('+');
  }
  if (v[v.size() - 1] == '+') {
    for (i = 0; i < v.size() - 1; i++) {
      cout << v[i];
    }
  } else {
    for (i = 0; i < v.size(); i++) {
      cout << v[i];
    }
  }
  return 0;
}
