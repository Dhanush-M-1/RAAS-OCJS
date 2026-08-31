#include <bits/stdc++.h>
using namespace std;
const bool online_judge = true;
const long long inf = 1LL << 60;
long long toInt(string s) {
  long long res;
  stringstream ss;
  ss << s;
  ss >> res;
  return res;
}
string toString(long long n) {
  stringstream ss;
  ss << n;
  return ss.str();
}
long long w, h;
vector<string> f;
typedef struct {
  long long x;
  long long y;
  long long dp;
  long long cp;
} state;
state memo[55][55][5][5];
long long dx[4] = {0, 1, 0, -1};
long long dy[4] = {-1, 0, 1, 0};
long long ex[4] = {-1, 0, 1, 0};
long long ey[4] = {0, -1, 0, 1};
state solve(long long y, long long x, long long dp, long long cp) {
  if (memo[y][x][dp][cp].x != -1) return memo[y][x][dp][cp];
  state ans;
  long long nx = x + dx[dp];
  long long ny = y + dy[dp];
  long long mx = x + ex[(dp + (cp ? 2 : 0)) % 4];
  long long my = y + ey[(dp + (cp ? 2 : 0)) % 4];
  if (f[ny][nx] == f[y][x]) {
    ans = solve(ny, nx, dp, cp);
  } else if (f[my][mx] == f[y][x]) {
    ans = solve(my, mx, dp, cp);
  } else {
    char c = f[ny][nx];
    if (c == '0') {
      if (cp == 0) {
        ans.y = y;
        ans.x = x;
        ans.dp = dp;
        ans.cp = 1;
      } else {
        ans.y = y;
        ans.x = x;
        ans.dp = (dp + 1) % 4;
        ans.cp = 0;
      }
    } else {
      ans.x = nx;
      ans.y = ny;
      ans.dp = dp;
      ans.cp = cp;
    }
  }
  memo[y][x][dp][cp] = ans;
  return ans;
}
void run() {
  long long m, n;
  cin >> m >> n;
  for (long long _ = 0; _ < m; _++) {
    string tmp;
    cin >> tmp;
    f.push_back(tmp);
  }
  w = f[0].size();
  h = m;
  for (long long i = 0; i < m; i++) {
    f[i] = "0" + f[i] + "0";
  }
  f.insert(f.begin(), string(w + 2, '0'));
  f.push_back(string(w + 2, '0'));
  for (long long i = 1; i <= h; i++) {
    for (long long j = 1; j <= w; j++) {
      for (long long dp = 0; dp <= 3; dp++) {
        for (long long cp = 0; cp <= 1; cp++) {
          memo[i][j][dp][cp].x = -1;
        }
      }
    }
  }
  for (long long i = 1; i <= h; i++) {
    for (long long j = 1; j <= w; j++) {
      for (long long dp = 0; dp <= 3; dp++) {
        for (long long cp = 0; cp <= 1; cp++) {
          solve(i, j, dp, cp);
        }
      }
    }
  }
  long long x = 1, y = 1, dp = 1, cp = 0;
  while (n--) {
    state next = memo[y][x][dp][cp];
    x = next.x;
    y = next.y;
    dp = next.dp;
    cp = next.cp;
  }
  cout << f[y][x] << endl;
}
int main(int argc, char *argv[]) {
  run();
  return 0;
}
