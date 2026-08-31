#include <bits/stdc++.h>
const int inf = 1039074182;
using namespace std;
int n, r, c;
string word[1000005];
int len[1000005];
int nxt[1000005];
pair<int, int> st[1000005][22];
int sum[1000005];
int calc(int start) {
  int res = 0;
  for (int i = 0; i < 22; i++) {
    if ((1 << i) & r) {
      res += st[start][i].second;
      start = st[start][i].first;
    }
  }
  return res;
}
void print(int start) {
  for (int i = 0; i < r; i++) {
    if (start == n) break;
    for (int j = start; j < nxt[start]; j++) {
      cout << word[j];
      if (j != nxt[start] - 1) cout << ' ';
    }
    cout << endl;
    start = nxt[start];
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n >> r >> c;
  for (int i = 0; i < n; i++) {
    cin >> word[i];
    len[i] = word[i].size();
  }
  sum[0] = len[0] + 1;
  for (int i = 1; i < n; i++) {
    sum[i] = sum[i - 1] + len[i] + 1;
  }
  for (int i = 0, j = 0; i < n; i++) {
    while (j < n && sum[j] - (i ? sum[i - 1] : 0) - 1 <= c) j++;
    nxt[i] = j;
  }
  for (int i = 0; i < n; i++) {
    st[i][0] = make_pair(nxt[i], nxt[i] - i);
  }
  for (int i = 0; i < 22; i++) {
    st[n][i] = make_pair(n, 0);
  }
  for (int k = 1; k < 22; k++) {
    for (int i = 0; i < n; i++) {
      st[i][k].first = st[st[i][k - 1].first][k - 1].first;
      st[i][k].second =
          st[i][k - 1].second + st[st[i][k - 1].first][k - 1].second;
    }
  }
  int res = -1, maxk = -1;
  int temp;
  for (int i = 0; i < n; i++) {
    temp = calc(i);
    if (temp > res) {
      res = temp;
      maxk = i;
    }
  }
  print(maxk);
  return 0;
}
