#include<bits/stdc++.h>

using namespace std;

typedef long long int64;

int main()
{
  int64 N, M, A, B, P, Q;

  cin >> N >> M >> A >> B >> P >> Q;

  if(A == 1 && B == 1) {
    int64 T = P + Q;
    if(N < (M + T - 1) / T) {
      cout << M - T * N << endl;
    } else {
      cout << min(M % T, T - M % T) << endl;
    }
  } else {
    int64 PA = P, QB = Q;
    vector< int64 > vs;
    for(int i = 0; i < min(42LL, N); i++) {
      vs.push_back(PA + QB);
      if((double) PA * A + QB * B > 1e18) break;
      PA *= A;
      QB *= B;
    }

    int mid = vs.size() / 2;
    int rest = vs.size() - mid;
    vector< int64 > ss(1 << mid, 0);
    for(int i = 0; i < (1 << mid); i++) {
      for(int j = 0; j < mid; j++) {
        if((i >> j) & 1) ss[i] += vs[j];
      }
    }
    sort(begin(ss), end(ss));
    ss.erase(unique(begin(ss), end(ss)), end(ss));

    int64 ret = 1LL << 60;
    for(int i = 0; i < (1 << rest); i++) {
      int64 now = 0;
      for(int j = 0; j < rest; j++) {
        if((i >> j) & 1) now += vs[mid + j];
      }
      auto ptr = lower_bound(begin(ss), end(ss), M - now);
      if(ptr != ss.end()) ret = min(ret, llabs(M - now - *ptr));
      if(ptr != ss.begin()) ret = min(ret, llabs(M - now - *--ptr));
    }

    cout << ret << endl;

  }
}