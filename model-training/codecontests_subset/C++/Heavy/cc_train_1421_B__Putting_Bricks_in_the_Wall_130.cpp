#include <bits/stdc++.h>
using namespace std;
long long T, N, M, ans, temp;
char m[200][2001];
int main(void) {
  ios::sync_with_stdio(false);
  cin.tie(NULL), cout.tie(NULL);
  cin >> T;
  for (long long t = 1; t <= T; t++) {
    cin >> N;
    for (long long i = 0; i < N; i++) {
      cin >> m[i];
    }
    vector<pair<long long, long long> > c;
    if (m[0][1] == '0' && m[1][0] == '0') {
      if (m[N - 1][N - 2] == '0') {
        c.push_back({N, N - 1});
      }
      if (m[N - 2][N - 1] == '0') {
        c.push_back({N - 1, N});
      }
    } else if (m[0][1] == '1' && m[1][0] == '1') {
      if (m[N - 1][N - 2] == '1') {
        c.push_back({N, N - 1});
      }
      if (m[N - 2][N - 1] == '1') {
        c.push_back({N - 1, N});
      }
    } else {
      if (m[N - 1][N - 2] == '0' && m[N - 2][N - 1] == '0') {
        if (m[0][1] == '0') {
          c.push_back({1, 2});
        }
        if (m[1][0] == '0') {
          c.push_back({2, 1});
        }
      } else if (m[N - 1][N - 2] == '1' && m[N - 2][N - 1] == '1') {
        if (m[0][1] == '1') {
          c.push_back({1, 2});
        }
        if (m[1][0] == '1') {
          c.push_back({2, 1});
        }
      } else {
        if (m[0][1] == '1') {
          c.push_back({1, 2});
        }
        if (m[1][0] == '1') {
          c.push_back({2, 1});
        }
        if (m[N - 1][N - 2] == '0') {
          c.push_back({N, N - 1});
        }
        if (m[N - 2][N - 1] == '0') {
          c.push_back({N - 1, N});
        }
      }
    }
    cout << c.size() << '\n';
    for (long long i = 0; i < c.size(); i++) {
      cout << c[i].first << ' ' << c[i].second << '\n';
    }
  }
  return 0;
}
