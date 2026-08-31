#include <bits/stdc++.h>
using namespace std;
int ok[28] = {0,  4,  7,  8,  11, 12, 14, 15, 16, 18, 19, 20, 21, 22,
              23, 24, 25, 26, 27, 28, 29, 30, 32, 33, 35, 36, 39, 42};
int main() {
  int t;
  cin >> t;
  for (int i = 0; i < t; i++) {
    long long n, tmp;
    cin >> n;
    tmp = n;
    vector<int> use[5], use_n[5];
    int dig[19] = {};
    int dign = log10(n);
    for (int j = 0; j < 19; j++) {
      dig[j] = tmp % 10;
      tmp /= 10;
    }
    set<int> st, st_n;
    set<int>::iterator it;
    st.insert(dig[dign]);
    for (int j = dign - 1; j >= 0; j--) {
      for (it = st.begin(); it != st.end(); it++) {
        for (int k = 0; k < 28; k++) {
          int hoge = (*it) - ok[k];
          if (hoge > 4) continue;
          if (hoge < 0) break;
          st_n.insert(hoge * 10 + dig[j]);
          use_n[hoge] = use[(*it) / 10];
          use_n[hoge].push_back(k);
        }
      }
      st = st_n;
      st_n.clear();
      for (int k = 0; k < 5; k++) use[k] = use_n[k];
    }
    bool flag = false;
    int mem = -1;
    for (it = st.begin(); it != st.end(); it++) {
      for (int k = 0; k < 28; k++) {
        if ((*it) == ok[k]) {
          flag = true;
          use[(*it) / 10].push_back(k);
          mem = (*it) / 10;
          break;
        }
      }
      if (flag) break;
    }
    if (!flag) {
      cout << -1 << endl;
      continue;
    }
    long long ans[6] = {};
    long long jo = 1;
    for (int j = 0; j < dign; j++) jo *= 10;
    for (int j = 0; j <= dign; j++) {
      int fuga = ok[use[mem][j]];
      int num4 = 0, num7 = 0;
      if (fuga % 7 == 0) num4 = 0;
      if (fuga % 7 == 1) num4 = 2;
      if (fuga % 7 == 2) num4 = 4;
      if (fuga % 7 == 3) num4 = 6;
      if (fuga % 7 == 4) num4 = 1;
      if (fuga % 7 == 5) num4 = 3;
      if (fuga % 7 == 6) num4 = 5;
      num7 = (fuga - num4 * 4) / 7;
      for (int k = 0; k < num4; k++) {
        ans[k] += 4 * jo;
      }
      for (int k = num4; k < num4 + num7; k++) {
        ans[k] += 7 * jo;
      }
      jo /= 10;
    }
    for (int j = 0; j < 6; j++) {
      cout << ans[j] << " ";
    }
    cout << endl;
  }
  return 0;
}
