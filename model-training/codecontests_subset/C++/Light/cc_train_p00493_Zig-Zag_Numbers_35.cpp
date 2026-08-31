#include<bits/stdc++.h>
typedef long long ll;
typedef unsigned long long ull;
using namespace std;
#define pb push_back
int dy[]={0, 0, 1, -1, 1, 1, -1, -1};
int dx[]={1, -1, 0, 0, 1, -1, -1, 1};

#define FOR(i,a,b) for (int i=(a);i<(b);i++)
#define RFOR(i,a,b) for (int i=(b)-1;i>=(a);i--)
#define REP(i,n) for (int i=0;i<(n);i++)
#define RREP(i,n) for (int i=(n)-1;i>=0;i--)
#define mp make_pair
#define fi first
#define sc second
string A,B;
ll M;
ll dp[2][2][4][10][1000];
ll mod = 10000;
int main(){
	cin >> A >> B;
	cin >> M;

	ll n = B.length();

	dp[0][0][0][0][0] = 1;

	REP(i,n) {
		REP(j,2) {
			REP(k,4) {
				REP(l,10) {
					REP(m,M) {
						ll lim = (j ? 9 : B[i] - '0');
						REP(d,lim + 1) {
							if(k == 0) {
								if(d == 0) {
									(dp[1][j || d < lim][0][d][(m * 10 + d) % M] += dp[0][j][k][l][m]) %= mod;
									continue;
								}
								(dp[1][j || d < lim][1][d][(m * 10 + d) % M] += dp[0][j][k][l][m]) %= mod;
							}else if(k == 1) {
								if(d == l) {
									continue;
								}
								ll e = 2 + (d > l);
								(dp[1][j || d < lim][e][d][(m * 10 + d) % M] += dp[0][j][k][l][m]) %= mod;
							}else if(k == 2) {
								if(d <= l) {
									continue;
								}
								(dp[1][j || d < lim][3][d][(m * 10 + d) % M] += dp[0][j][k][l][m]) %= mod;
							}else if(k == 3) {
								if(d >= l) {
									continue;
								}
								(dp[1][j || d < lim][2][d][(m * 10 + d) % M] += dp[0][j][k][l][m]) %= mod;
							}
						}
					}
				}
			}
		}
		REP(j,2) {
			REP(k,4) {
				REP(l,10) {
					REP(m,M) {
						dp[0][j][k][l][m] = dp[1][j][k][l][m];
						dp[1][j][k][l][m] = 0;
					}
				}
			}
		}
	}
	ll ans = 0;
	REP(j,2) {
		REP(k,4) {
			REP(l,10) {
				(ans += dp[0][j][k][l][0]) %= mod;
			}
		}
	}


	n = A.length();

	REP(j,2) {
		REP(k,4) {
			REP(l,10) {
				REP(m,M) {
					dp[0][j][k][l][m] = 0;
					dp[1][j][k][l][m] = 0;
				}
			}
		}
	}
	dp[0][0][0][0][0] = 1;

	REP(i,n) {
		REP(j,2) {
			REP(k,4) {
				REP(l,10) {
					REP(m,M) {
						ll lim = (j ? 9 : A[i] - '0');
						REP(d,lim + 1) {
							if(k == 0) {
								if(d == 0) {
									(dp[1][j || d < lim][0][d][(m * 10 + d) % M] += dp[0][j][k][l][m]) %= mod;
									continue;
								}
								(dp[1][j || d < lim][1][d][(m * 10 + d) % M] += dp[0][j][k][l][m]) %= mod;
							}else if(k == 1) {
								if(d == l) {
									continue;
								}
								ll e = 2 + (d > l);
								(dp[1][j || d < lim][e][d][(m * 10 + d) % M] += dp[0][j][k][l][m]) %= mod;
							}else if(k == 2) {
								if(d <= l) {
									continue;
								}
								(dp[1][j || d < lim][3][d][(m * 10 + d) % M] += dp[0][j][k][l][m]) %= mod;
							}else if(k == 3) {
								if(d >= l) {
									continue;
								}
								(dp[1][j || d < lim][2][d][(m * 10 + d) % M] += dp[0][j][k][l][m]) %= mod;
							}
						}
					}
				}
			}
		}
		REP(j,2) {
			REP(k,4) {
				REP(l,10) {
					REP(m,M) {
						dp[0][j][k][l][m] = dp[1][j][k][l][m];
						dp[1][j][k][l][m] = 0;
					}
				}
			}
		}
	}

	REP(k,4) {
		REP(l,10) {
			(ans += mod - dp[0][1][k][l][0]) %= mod;
		}
	}
	cout << ans << endl;

	return 0;
}

