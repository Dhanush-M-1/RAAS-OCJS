#include <bits/stdc++.h>
using namespace std;
void cline() { cout << '\n'; }
template <typename T, typename... V>
void cline(T t, V... v) {
  cout << t;
  if (sizeof...(v)) cout << ' ';
  cline(v...);
}
void cspc() { cout << ' '; }
template <typename T, typename... V>
void cspc(T t, V... v) {
  cout << t;
  if (sizeof...(v)) cout << ' ';
  cspc(v...);
}
const int N = 1e6 + 4;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  string s;
  getline(cin, s);
  int frep = 0, fren = 0;
  int n = s.size();
  bool flag = 1;
  for (int i = 0; i < n; i++) {
    if (s[i] == '?') {
      if (flag) {
        frep++;
        flag = 0;
      } else {
        fren++;
      }
    } else if (s[i] == '+') {
      flag = 1;
    }
  }
  int last = 0, fac = 1;
  for (int i = n - 1; i >= 0; i--) {
    if (s[i] == ' ') {
      break;
    }
    int num = s[i] - '0';
    last += fac * num;
    fac = fac * 10;
  }
  if ((frep > (fren + 1) * last) || (fren > (frep - 1) * last)) {
    cspc("Impossible");
    return 0;
  }
  cline("Possible");
  vector<int> vp, vn;
  for (int i = 0; i < fren; i++) {
    vn.push_back(1);
  }
  for (int i = 0; i < frep; i++) {
    vp.push_back(1);
  }
  if (fren + last - frep > 0) {
    int extra = fren + last - frep;
    int add = extra / frep;
    int perc = extra % frep;
    for (int i = 0; i < frep; i++) {
      if (i < perc) {
        vp[i] += add + 1;
      } else {
        vp[i] += add;
      }
    }
  } else if (fren + last - frep < 0) {
    int extra = frep - fren - last;
    int add = extra / fren;
    int perc = extra % fren;
    for (int i = 0; i < fren; i++) {
      if (i < perc) {
        vn[i] += add + 1;
      } else {
        vn[i] += add;
      }
    }
  }
  int j = 0, k = 0;
  flag = 1;
  for (int i = 0; i < n; i++) {
    if (s[i] == '?') {
      if (flag) {
        cout << vp[j];
        j++;
        flag = 0;
      } else {
        cout << vn[k];
        k++;
      }
    } else {
      if (s[i] == '+') {
        flag = 1;
      }
      cout << s[i];
    }
  }
  return 0;
}
