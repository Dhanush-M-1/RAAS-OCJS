#include <bits/stdc++.h>
using namespace std;
int n, m, r, c;
char a[810][810], b[810][810];
bitset<650000> s[30], st;
int main() {
  st.set();
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    scanf("%s", a[i]);
  }
  cin >> r >> c;
  for (int i = 0; i < n + r; i++) {
    for (int j = 0; j < m + c; j++) {
      a[i][j] = a[i % n][j % m];
      s[a[i][j] - 'a'][i * (m + c) + j] = 1;
    }
  }
  for (int i = 0; i < r; i++) {
    scanf("%s", b[i]);
  }
  for (int i = 0; i < r; i++) {
    for (int j = 0; j < c; j++) {
      if (b[i][j] != '?') {
        st &= (s[(b[i][j] - 'a')] >> (i * (m + c) + j));
      }
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      cout << st[i * (m + c) + j];
    }
    cout << endl;
  }
  return 0;
}
