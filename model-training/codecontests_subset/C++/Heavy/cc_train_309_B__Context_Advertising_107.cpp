#include <bits/stdc++.h>
using namespace std;
const int MOD = 1000000007;
const int UNDEF = -1;
const long long INF = 1e18;
template <typename T>
inline bool chkmax(T &aa, T bb) {
  return aa < bb ? aa = bb, true : false;
}
template <typename T>
inline bool chkmin(T &aa, T bb) {
  return aa > bb ? aa = bb, true : false;
}
int rint();
char rch();
long long rlong();
const int mn = 1e6 + 2;
string s[mn];
int p2w[6 * mn];
int w2p[mn];
int rr[mn];
vector<int> r2l[mn];
vector<vector<int> > v[mn];
bool cmp(const int &x, const int &y) {
  return v[rr[x]].size() > v[rr[y]].size();
}
int main() {
  int n, rows, cols;
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> rows >> cols;
  for (int i = 1; i <= n; i++) cin >> s[i];
  int alen = 0;
  {
    int sidx = 0;
    for (int wi = 1; wi <= n; wi++) {
      w2p[wi] = sidx;
      int slen = s[wi].length();
      for (int i = 0; i < slen; i++) {
        p2w[sidx] = wi;
        sidx++;
      }
      p2w[sidx] = wi + 1;
      sidx++;
    }
    alen = sidx;
  }
  for (int wi = 1; wi <= n; wi++) {
    int spos = w2p[wi];
    int epos = spos + cols;
    int r = n + 1;
    if (epos < alen) r = p2w[epos];
    int l = wi;
    if (r > l) {
      r2l[r].push_back(l);
    }
  }
  for (int x = 0; x <= n + 1; x++) rr[x] = x;
  int bestsz = -1, bestl = 1;
  for (int r = 1; r <= n + 1; r++) {
    int sz = r2l[r].size();
    if (sz > 0) {
      sort(r2l[r].begin(), r2l[r].end(), cmp);
      rr[r] = rr[r2l[r][0]];
    }
    auto &vr = v[rr[r]];
    vector<int> tmp;
    tmp.push_back(r);
    vr.push_back(tmp);
    int rsz = vr.size();
    int rslo = rsz - 1 - rows;
    int rslo0 = max(0, rslo);
    for (int li = 1; li < sz; li++) {
      int l = r2l[r][li];
      auto &vl = v[rr[l]];
      int lsz = vl.size();
      for (int ls = lsz - 1, rs = rsz - 2; ls >= 0 && rs >= rslo0; ls--, rs--) {
        for (auto &w : vl[ls]) {
          vr[rs].push_back(w);
        }
      }
    }
    if (r != n + 1 && s[r].length() <= cols) {
      if (rslo >= 0) {
        for (auto &l : vr[rslo]) {
          int candsz = r - l;
          if (candsz > bestsz) {
            bestsz = candsz;
            bestl = l;
          }
        }
      }
    } else {
      for (int rs = rslo0; rs < rsz; rs++) {
        for (auto &l : vr[rs]) {
          int candsz = r - l;
          if (candsz > bestsz) {
            bestsz = candsz;
            bestl = l;
          }
        }
      }
    }
  }
  while (rows--) {
    int c = -1;
    while (bestl <= n) {
      int slen = 1 + s[bestl].length();
      if (c + slen > cols) {
        break;
      }
      if (c != -1) printf(" ");
      c += slen;
      printf("%s", s[bestl].c_str());
      bestl++;
    }
    printf("\n");
  }
}
static char stdinBuffer[1024];
static char *stdinDataEnd = stdinBuffer + sizeof(stdinBuffer);
static const char *stdinPos = stdinDataEnd;
void readAhead(size_t amount) {
  size_t remaining = stdinDataEnd - stdinPos;
  if (remaining < amount) {
    memmove(stdinBuffer, stdinPos, remaining);
    size_t sz = fread(stdinBuffer + remaining, 1,
                      sizeof(stdinBuffer) - remaining, stdin);
    stdinPos = stdinBuffer;
    stdinDataEnd = stdinBuffer + remaining + sz;
    if (stdinDataEnd != stdinBuffer + sizeof(stdinBuffer)) *stdinDataEnd = 0;
  }
}
int rint() {
  readAhead(16);
  int x = 0;
  bool neg = false;
  while (*stdinPos == ' ' || *stdinPos == '\n') ++stdinPos;
  if (*stdinPos == '-') {
    ++stdinPos;
    neg = true;
  }
  while (*stdinPos >= '0' && *stdinPos <= '9') {
    x *= 10;
    x += *stdinPos - '0';
    ++stdinPos;
  }
  return neg ? -x : x;
}
char rch() {
  readAhead(16);
  while (*stdinPos == ' ' || *stdinPos == '\n') ++stdinPos;
  char ans = *stdinPos;
  ++stdinPos;
  return ans;
}
long long rlong() {
  readAhead(32);
  long long x = 0;
  bool neg = false;
  while (*stdinPos == ' ' || *stdinPos == '\n') ++stdinPos;
  if (*stdinPos == '-') {
    ++stdinPos;
    neg = true;
  }
  while (*stdinPos >= '0' && *stdinPos <= '9') {
    x *= 10;
    x += *stdinPos - '0';
    ++stdinPos;
  }
  return neg ? -x : x;
}
