#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<cmath>
#include<iostream>
#include<string>
#include<vector>
#include<map>
#include<list>
#include<queue>
#include<deque>
#include<algorithm>
#include<numeric>
#include<utility>
#include<complex>
#include<functional>
 
using namespace std;

/* constant */

#define H	(4)
#define W	(4)
#define HW	(H * W)

#define CH	(H - 1)
#define CW	(W - 1)
#define CHW	(CH * CW)

#define MAX_N	(365)
#define MAX_R	(6)

#define C_FALSE	(1)
#define C_TRUE	(2)

/* typedef */

typedef vector<int> vi;
typedef vector<long long> vl;
typedef vector<double> vd;
typedef pair<int,int> pii;
typedef pair<long,long> pll;
typedef long long ll;

struct pt_t {
  int x, y;
};

/* global variables */

static pt_t dxys[] = {
  {0, 0}, {1, 0}, {2, 0}, {0, -1}, {0, -2}, {-1, 0}, {-2, 0}, {0, 1}, {0, 2}
};

static int cache[MAX_N][CHW][MAX_R + 1][MAX_R + 1][MAX_R + 1][MAX_R + 1];

static int n;
static bool fcs[MAX_N][HW];

static int ccvrs[CHW][4];
static vector<int> cnbrs[CHW];

/* subroutines */

void print_foo() {
  cout << "ccvrs: [";
  for (int i = 0; i < CHW; i++) {
    if (i > 0) cout << ",";
    cout << "[";
    for (int j = 0; j < 4; j++) {
      if (j > 0) cout << ",";
      cout << ccvrs[i][j];
    }
    cout << "]";
  }
  cout << "]" << endl;

  cout << "cnbrs: [";
  for (int i = 0; i < CHW; i++) {
    if (i > 0) cout << ",";
    cout << "[";
    for (int j = 0; j < cnbrs[i].size(); j++) {
      if (j > 0) cout << ",";
      cout << cnbrs[i][j];
    }
    cout << "]";
  }
  cout << "]" << endl;
}

void print_fcs() {
  cout << "fcs: [";
  for (int i = 0; i < n; i++) {
    if (i > 0) cout << ",";
    cout << "[";
    for (int j = 0; j < HW; j++) {
      if (j > 0) cout << ",";
      cout << fcs[i][j];
    }
    cout << "]";
  }
  cout << "]" << endl;
}

int check_rec(int k, int cid, int r0, int r2, int r6, int r8) {
  //printf("k=%d,cid=%d,r0=%d,r2=%d,r6=%d,r8=%d\n", k, cid, r0, r2, r6, r8);

  if (k >= n) return C_TRUE;

  int& cc = cache[k][cid][r0][r2][r6][r8];
  //cout << "cc = " << cc << endl;
  if (cc > 0) return cc;

  for (int i = 0; i < 4; i++)
    if (fcs[k][ccvrs[cid][i]]) {
      //printf("fcs[%d][%d] = %d\n", k, ccvrs[cid][i], fcs[k][ccvrs[cid][i]]);
      return (cc = C_FALSE);
    }

  int rr0 = r0 + 1;
  int rr2 = r2 + 1;
  int rr6 = r6 + 1;
  int rr8 = r8 + 1;

  switch (cid) {
  case 0: rr0 = 0; break;
  case 2: rr2 = 0; break;
  case 6: rr6 = 0; break;
  case 8: rr8 = 0; break;
  }

  if (rr0 > MAX_R || rr2 > MAX_R || rr6 > MAX_R || rr8 > MAX_R)
    return (cc = C_FALSE);

  for (int i = 0; i < cnbrs[cid].size(); i++) {
    int cid0 = cnbrs[cid][i];
    if (check_rec(k + 1, cid0, rr0, rr2, rr6, rr8) == C_TRUE)
      return (cc = C_TRUE);
  }

  return (cc = C_FALSE);
}

/* main */

int main() {
  for (int y = 0; y < CH; y++)
    for (int x = 0; x < CW; x++) {
      int cid = y * CW + x;
      int cpos = y * W + x;
      ccvrs[cid][0] = cpos;
      ccvrs[cid][1] = cpos + 1;
      ccvrs[cid][2] = cpos + W;
      ccvrs[cid][3] = cpos + W + 1;

      cnbrs[cid].clear();

      for (int d = 0; d < 9; d++) {
	int x0 = x + dxys[d].x;
	int y0 = y + dxys[d].y;
	if (x0 >= 0 && x0 < CW && y0 >= 0 && y0 < CH) {
	  int cid0 = y0 * CW + x0;
	  cnbrs[cid].push_back(cid0);
	}
      }
      sort(cnbrs[cid].begin(), cnbrs[cid].end());
    }
  //print_foo(); exit(0);

  for (;;) {
    cin >> n;
    if (n == 0) break;

    memset(fcs, 0, sizeof(fcs));
    int c;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < HW; j++) {
	cin >> c;
	fcs[i][j] = (c == 1);
      }
    //print_fcs();

    //cout << "sizeof(cache) = " << sizeof(cache) << endl;
    memset(cache, 0, sizeof(cache));

    cout << (check_rec(0, 1 * CW + 1, 0, 0, 0, 0) - 1) << endl;
  }

  return 0;
}