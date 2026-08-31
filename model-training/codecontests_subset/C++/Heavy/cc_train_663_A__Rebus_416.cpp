#include <bits/stdc++.h>
using namespace std;
int get(string s) {
  int res = 0, pw = 1;
  while (!s.empty()) {
    res += (s.back() - '0') * pw;
    pw *= 10;
    s.pop_back();
  }
  return res;
}
int main() {
  string s;
  getline(cin, s);
  vector<char> vec;
  for (char c : s) {
    if (c == ' ') {
      continue;
    } else {
      vec.push_back(c);
    }
  }
  string sn = "";
  bool flag = 0;
  for (char c : vec) {
    if (c == '=') {
      flag = 1;
      continue;
    }
    if (flag) {
      sn += c;
    }
  }
  int n = get(sn);
  int mn = 0, mx = 0;
  vector<int> small, big;
  for (int i = 0; i < vec.size(); i++) {
    if (vec[i] == '=') {
      break;
    }
    if (i == 0) {
      mn = 1, mx = n;
      big.push_back(n);
      small.push_back(1);
      continue;
    }
    if (vec[i] == '?') {
      if (vec[i - 1] == '-') {
        mx -= 1;
        mn -= n;
        big.push_back(1);
        small.push_back(n);
      }
      if (vec[i - 1] == '+') {
        mx += n;
        mn += 1;
        big.push_back(n);
        small.push_back(1);
      }
    }
  }
  if (mn <= n && n <= mx) {
    puts("Possible");
    int id = 0;
    for (int i = 0; i < vec.size(); i++) {
      if (i == 0) {
        if (mn < n) {
          int x = min(n - small[id], n - mn);
          mn += x;
          small[id] += x;
        }
        id++;
        continue;
      }
      if (vec[i] == '?') {
        if (mn < n) {
          if (vec[i - 1] == '-') {
            int x = min(small[id] - 1, n - mn);
            mn += x;
            small[id] -= x;
          }
          if (vec[i - 1] == '+') {
            int x = min(n - small[id], n - mn);
            mn += x;
            small[id] += x;
          }
        }
        id++;
      }
    }
    id = 0;
    for (char c : vec) {
      if (c == '?') {
        cout << small[id] << " ";
        id++;
      } else {
        cout << c << " ";
        if (c == '=') {
          cout << n;
          break;
        }
      }
    }
  } else {
    puts("Impossible");
  }
}
