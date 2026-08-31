#include <bits/stdc++.h>
using namespace std;
struct st {
  long long ar[3][3];
  vector<long long> ar1[3][3];
};
long long memo[200001][10];
vector<st> arr;
vector<vector<pair<long long, long long> > > v;
long long n;
long long func(int x, int cnt) {
  if (x >= n) return 0;
  if (x == n - 1) {
    long long m = 0;
    if (cnt < 7) {
      for (int i = 0; i < 3; i++)
        for (int j = 0; j < 3; j++) m = max(m, arr[x].ar[i][j]);
    }
    if (cnt == 7) {
      if (arr[x].ar[2][2] != 0) {
        long long zz = max(max(arr[x].ar1[2][2][0], arr[x].ar1[2][2][1]),
                           arr[x].ar1[2][2][2]);
        m = max(m, (arr[x].ar[2][2] - zz) + zz * 2);
      }
    } else if (cnt == 8) {
      if (arr[x].ar[2][2] != 0) {
        long long zz = max(max(arr[x].ar1[2][2][0], arr[x].ar1[2][2][1]),
                           arr[x].ar1[2][2][2]);
        m = max(m, (arr[x].ar[2][2] - zz) + zz * 2);
      }
      if (arr[x].ar[1][1] != 0) {
        long long zz = max(arr[x].ar1[1][1][0], arr[x].ar1[1][1][1]);
        m = max(m, (arr[x].ar[1][1] - zz) + zz * 2);
      }
      if (arr[x].ar[2][1] != 0) {
        long long zz = max(arr[x].ar1[2][1][0], arr[x].ar1[2][1][1]);
        m = max(m, (arr[x].ar[2][1] - zz) + zz * 2);
      }
    } else if (cnt == 9) {
      if (arr[x].ar[0][0] != 0) {
        m = max(m, arr[x].ar[0][0] * 2);
      }
      if (arr[x].ar[1][0] != 0) {
        m = max(m, arr[x].ar[1][0] * 2);
      }
      if (arr[x].ar[2][0] != 0) {
        m = max(m, arr[x].ar[2][0] * 2);
      }
      if (arr[x].ar[2][2] != 0) {
        long long zz = max(max(arr[x].ar1[2][2][0], arr[x].ar1[2][2][1]),
                           arr[x].ar1[2][2][2]);
        m = max(m, (arr[x].ar[2][2] - zz) + zz * 2);
      }
      if (arr[x].ar[1][1] != 0) {
        long long zz = max(arr[x].ar1[1][1][0], arr[x].ar1[1][1][1]);
        m = max(m, (arr[x].ar[1][1] - zz) + zz * 2);
      }
      if (arr[x].ar[2][1] != 0) {
        long long zz = max(arr[x].ar1[2][1][0], arr[x].ar1[2][1][1]);
        m = max(m, (arr[x].ar[2][1] - zz) + zz * 2);
      }
    }
    return m;
  }
  if (memo[x][cnt] != -1) return memo[x][cnt];
  long long m = 0;
  m = func(x + 1, cnt);
  if (arr[x].ar[0][0] != 0) {
    if (cnt == 9)
      m = max(m, arr[x].ar[0][0] * 2 + func(x + 1, 0));
    else
      m = max(m, arr[x].ar[0][0] + func(x + 1, cnt + 1));
  }
  if (arr[x].ar[1][0] != 0) {
    if (cnt == 9)
      m = max(m, arr[x].ar[1][0] * 2 + func(x + 1, 0));
    else
      m = max(m, arr[x].ar[1][0] + func(x + 1, cnt + 1));
  }
  if (arr[x].ar[2][0] != 0) {
    if (cnt == 9)
      m = max(m, arr[x].ar[2][0] * 2 + func(x + 1, 0));
    else
      m = max(m, arr[x].ar[2][0] + func(x + 1, cnt + 1));
  }
  if (arr[x].ar[1][1] != 0) {
    long long x1 = arr[x].ar1[1][1][0];
    long long y = arr[x].ar1[1][1][1];
    if (cnt == 8) {
      m = max(m, x1 + 2 * y + func(x + 1, 0));
      m = max(m, y + 2 * x1 + func(x + 1, 0));
    } else if (cnt == 9) {
      m = max(m, 2 * y + x1 + func(x + 1, 1));
      m = max(m, 2 * x1 + y + func(x + 1, 1));
    } else {
      m = max(m, x1 + y + func(x + 1, cnt + 2));
    }
  }
  if (arr[x].ar[2][1] != 0) {
    long long x1 = arr[x].ar1[2][1][0];
    long long y = arr[x].ar1[2][1][1];
    if (cnt == 8) {
      m = max(m, x1 + 2 * y + func(x + 1, 0));
      m = max(m, y + 2 * x1 + func(x + 1, 0));
    } else if (cnt == 9) {
      m = max(m, 2 * y + x1 + func(x + 1, 1));
      m = max(m, 2 * x1 + y + func(x + 1, 1));
    } else {
      m = max(m, x1 + y + func(x + 1, cnt + 2));
    }
  }
  if (arr[x].ar[2][2] != 0) {
    long long x1 = arr[x].ar1[2][2][0];
    long long y = arr[x].ar1[2][2][1];
    long long z = arr[x].ar1[2][2][2];
    if (cnt == 7) {
      m = max(m, x1 + y + 2 * z + func(x + 1, 0));
      m = max(m, y + z + 2 * x1 + func(x + 1, 0));
      m = max(m, x1 + z + 2 * y + func(x + 1, 0));
    }
    if (cnt == 8) {
      m = max(m, x1 + y + 2 * z + func(x + 1, 1));
      m = max(m, y + z + 2 * x1 + func(x + 1, 1));
      m = max(m, x1 + z + 2 * y + func(x + 1, 1));
    } else if (cnt == 9) {
      m = max(m, x1 + y + 2 * z + func(x + 1, 2));
      m = max(m, y + z + 2 * x1 + func(x + 1, 2));
      m = max(m, x1 + z + 2 * y + func(x + 1, 2));
    } else {
      m = max(m, x1 + y + z + func(x + 1, cnt + 3));
    }
  }
  memo[x][cnt] = m;
  return m;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cin >> n;
  v.resize(n);
  arr.resize(n);
  long long temp = 0;
  for (int j = 0; j < n; j++) {
    cin >> temp;
    v[j].resize(temp);
    priority_queue<long long> q1, q2, q3;
    for (int var1 = 0; var1 < 3; var1++)
      for (int var2 = 0; var2 < 3; var2++) {
        arr[j].ar[var1][var2] = 0;
      }
    for (int i = 0; i < temp; i++) {
      cin >> v[j][i].first >> v[j][i].second;
      if (v[j][i].first == 1)
        q1.push(v[j][i].second);
      else if (v[j][i].first == 2)
        q2.push(v[j][i].second);
      else
        q3.push(v[j][i].second);
    }
    if (q1.size() == 0) {
      if (q2.size() != 0) {
        arr[j].ar[1][0] = q2.top();
      }
    } else {
      arr[j].ar[0][0] = q1.top();
      if (q2.size() == 0) {
        arr[j].ar[1][0] = 0;
        if (q1.size() > 1) {
          long long te = q1.top();
          q1.pop();
          arr[j].ar[1][1] = q1.top() + te;
          arr[j].ar1[1][1].push_back(te);
          arr[j].ar1[1][1].push_back(q1.top());
          q1.push(te);
        }
        arr[j].ar[1][2] = 0;
      } else {
        arr[j].ar[1][0] = q2.top();
        if (q1.size() > 1) {
          long long te = q1.top();
          q1.pop();
          arr[j].ar[1][1] = q1.top() + te;
          arr[j].ar1[1][1].push_back(te);
          arr[j].ar1[1][1].push_back(q1.top());
          q1.push(te);
        }
        arr[j].ar[1][2] = 0;
      }
    }
    if (q3.size() != 0)
      arr[j].ar[2][0] = q3.top();
    else
      arr[j].ar[2][0] = 0;
    if (!q1.empty() && !q2.empty()) {
      arr[j].ar[2][1] = q1.top() + q2.top();
      arr[j].ar1[2][1].push_back(q1.top());
      arr[j].ar1[2][1].push_back(q2.top());
    } else
      arr[j].ar[2][1] = 0;
    if (q1.size() > 2) {
      arr[j].ar[2][2] = 0;
      arr[j].ar[2][2] += q1.top();
      arr[j].ar1[2][2].push_back(q1.top());
      q1.pop();
      arr[j].ar[2][2] += q1.top();
      arr[j].ar1[2][2].push_back(q1.top());
      q1.pop();
      arr[j].ar[2][2] += q1.top();
      arr[j].ar1[2][2].push_back(q1.top());
    } else {
      arr[j].ar[2][2] = 0;
    }
  }
  for (int i1 = 0; i1 < 200001; i1++)
    for (int j1 = 0; j1 < 10; j1++) memo[i1][j1] = -1;
  cout << func(0, 0) << "\n";
  return 0;
}
