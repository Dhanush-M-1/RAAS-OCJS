#include <bits/stdc++.h>
using namespace std;
int myRnd() { return abs(((rand() << 15) ^ rand())); }
int myRnd(int L, int R) {
  return abs(((rand() << 15) ^ rand())) % (R - L + 1) + L;
}
void Parr(int *arr, int L, int R) {
  for (int i = L; R >= i; i++) {
    printf("%d%c", arr[i], " \n"[i == R]);
  }
}
void Pvec(vector<int> v) {
  for (int i = 0; ((int)(v).size()) > i; i++) {
    printf("%d%c", v[i], " \n"[i == ((int)(v).size()) - 1]);
  }
}
void Sarr(int *arr, int L, int R) {
  for (int i = L; R >= i; i++) {
    scanf("%d", &(arr[i]));
    ;
  }
}
const int N = 2e5 + 6;
const int INF = 0x3f3f3f3f;
const int mod = 1000000000 + 7;
int a[N];
vector<int> G[N];
bool dp[2][N];
void dfs(int now, int par) {
  vector<int> child;
  for (int i : G[now]) {
    if (i != par) {
      child.push_back(i);
      dfs(i, now);
    }
  }
  if (((int)(child).size()) == 0) {
    dp[1][now] = true;
    dp[0][now] = false;
  } else {
    int _1L = 0, _1R = 0;
    for (int i : child) {
      if (dp[0][i] && dp[1][i]) {
        _1R++;
      } else if (dp[1][i]) {
        _1L++;
        _1R++;
      }
    }
    if (_1R == _1L) {
      if (_1L % 2 == 0) {
        dp[1][now] = true;
        dp[0][now] = false;
      } else {
        dp[0][now] = true;
        dp[1][now] = false;
      }
    } else {
      dp[0][now] = dp[1][now] = true;
    }
  }
}
vector<int> ans[2][N];
int lc[N], rc[N];
int head[2][N], tail[2][N];
void dfs2(int now, int par) {
  vector<int> child;
  for (int i : G[now]) {
    if (i != par) {
      child.push_back(i);
      dfs2(i, now);
    }
  }
  if (((int)(child).size()) == 0) {
    head[1][now] = tail[1][now] = now;
  } else {
    int _1L = 0, _1R = 0;
    for (int i : child) {
      if (dp[0][i] && dp[1][i]) {
        _1R++;
      } else if (dp[1][i]) {
        _1L++;
        _1R++;
      }
    }
    if (_1R == _1L) {
      if (_1L % 2 == 0) {
        int last = -1;
        for (int i : child) {
          if (!dp[1][i]) {
            if (last == -1) {
              head[1][now] = head[0][i];
              last = tail[0][i];
            } else {
              int _ = head[0][i];
              rc[last] = _;
              lc[_] = last;
              last = tail[0][i];
            }
          }
        }
        if (last == -1) {
          head[1][now] = now;
          last = now;
        } else {
          int _ = now;
          rc[last] = now;
          lc[_] = last;
          last = now;
        }
        for (int i : child) {
          if (dp[1][i]) {
            int _ = head[1][i];
            rc[last] = _;
            lc[_] = last;
            last = tail[1][i];
          }
        }
        tail[1][now] = last;
      } else {
        int last = -1;
        for (int i : child) {
          if (!dp[1][i]) {
            if (last == -1) {
              head[0][now] = head[0][i];
              last = tail[0][i];
            } else {
              int _ = head[0][i];
              rc[last] = _;
              lc[_] = last;
              last = tail[0][i];
            }
          }
        }
        if (last == -1) {
          head[0][now] = now;
          last = now;
        } else {
          int _ = now;
          rc[last] = now;
          lc[_] = last;
          last = now;
        }
        for (int i : child) {
          if (dp[1][i]) {
            int _ = head[1][i];
            rc[last] = _;
            lc[_] = last;
            last = tail[1][i];
          }
        }
        tail[0][now] = last;
      }
    } else {
      vector<int> child1, child2;
      vector<int> choice;
      for (int i : child) {
        if (dp[0][i] && dp[1][i]) {
          choice.push_back(i);
        } else if (dp[1][i]) {
          child1.push_back(i);
          child2.push_back(i);
        }
      }
      if (((int)(child1).size()) % 2 == 1) {
        child1.push_back(choice[0]);
      } else if (((int)(child1).size()) % 2 == 0) {
        child2.push_back(choice[0]);
      }
      int last = -1;
      for (int i : child2) {
        if (!dp[1][i]) {
          if (last == -1) {
            head[1][now] = head[0][i];
            last = tail[0][i];
          } else {
            int _ = head[0][i];
            rc[last] = _;
            lc[_] = last;
            last = tail[0][i];
          }
        }
      }
      if (last == -1) {
        head[1][now] = now;
        last = now;
      } else {
        int _ = now;
        rc[last] = now;
        lc[_] = last;
        last = now;
      }
      for (int i : child2) {
        if (dp[1][i]) {
          int _ = head[1][i];
          rc[last] = _;
          lc[_] = last;
          last = tail[1][i];
        }
      }
      tail[1][now] = last;
      last = -1;
      for (int i : child1) {
        if (!dp[1][i]) {
          if (last == -1) {
            head[0][now] = head[0][i];
            last = tail[0][i];
          } else {
            int _ = head[0][i];
            rc[last] = _;
            lc[_] = last;
            last = tail[0][i];
          }
        }
      }
      if (last == -1) {
        head[0][now] = now;
        last = now;
      } else {
        int _ = now;
        rc[last] = now;
        lc[_] = last;
        last = now;
      }
      for (int i : child1) {
        if (dp[1][i]) {
          int _ = head[1][i];
          rc[last] = _;
          lc[_] = last;
          last = tail[1][i];
        }
      }
      tail[0][now] = last;
    }
  }
}
int main() {
  srand(time(NULL));
  int n;
  scanf("%d", &(n));
  ;
  for (int i = 1; (n) >= i; ++i) {
    int p;
    scanf("%d", &(p));
    ;
    if (p) {
      G[i].push_back(p);
      G[p].push_back(i);
    }
  }
  dfs(1, 1);
  if (!dp[1][1]) {
    puts("NO");
    return 0;
  }
  puts("YES");
  for (int i = 1; n >= i; i++) {
    lc[i] = rc[i] = i;
  }
  dfs2(1, 1);
  int start = -1;
  for (int i = 1; n >= i; i++) {
    if (lc[i] == i) {
      start = i;
      break;
    }
  }
  assert(start != -1);
  for (int i = 1; n >= i; i++) {
    printf("%d\n", start);
    start = rc[start];
  }
}
