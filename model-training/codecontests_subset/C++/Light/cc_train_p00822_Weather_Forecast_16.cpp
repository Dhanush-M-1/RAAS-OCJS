#include <vector>
#include <list>
#include <map>
#include <set>
#include <stack>
#include <queue>
#include <deque>
#include <algorithm>
#include <utility>
#include <functional>
#include <sstream>
#include <iostream>
#include <cstdio>
#include <cmath>
#include <cstdlib>
#include <cctype>
#include <string>
#include <cstring>
#include <ctime>
#include <climits>
#include <cassert>
#include <memory>
#include <time.h>
using namespace std;
inline int toInt(string s) {int v; istringstream sin(s);sin>>v;return v;}
template<class T> inline string toString(T x) {ostringstream sout;sout<<x;return sout.str();}
typedef vector<int> vi;
typedef vector<vi> vvi;
typedef vector<string> vs;
typedef pair<int, int> pii;
typedef long long ll;
#define ALL(a) (a).begin(),(a).end()
#define RALL(a) (a).rbegin(),(a).rend()
#define EXIST(s,e) ((s).find(e)!=(s).end())
#define FOR(i,a,b) for(int i=(a);i<(b);++i)
#define REP(i,n) FOR(i,0,n)
const double EPS = 1e-9;
const double PI  = acos(-1.0);

typedef vector<vvi> vvvi;

bool satisfied(vvi &field,int y,int x){
	FOR(i,y,y+2){
		FOR(j,x,x+2){
			if(field[i][j]){
				return false;
			}
		}
	}
	return true;
}

int h(int y,int x){
	return y*3+x;
}

bool thirsty(vi pos){
	vvi wetness(4,vi(4));
	REP(i,pos.size()){
		int y=pos[i]/3;
		int x=pos[i]%3;
		FOR(j,y,y+2){
			FOR(k,x,x+2){
				wetness[j][k]++;
			}
		}
	}
	REP(i,4){
		REP(j,4){
			if(wetness[i][j]==0){
				return true;
			}
		}
	}
	return false;
}

int dp[2][9][9][9][9][9][9];
int main(){
	int N;
	while(cin>>N,N){
		REP(day,2)REP(i,9)REP(j,9)REP(k,9)REP(l,9)REP(m,9)REP(n,9)dp[day][i][j][k][l][m][n]=0;
		int d=0;
		REP(day,N){
			vvi field(4,vi(4));
			REP(i,4){
				REP(j,4){
					cin>>field[i][j];
				}
			}
			REP(i,9)REP(j,9)REP(k,9)REP(l,9)REP(m,9)REP(n,9)dp[d][i][j][k][l][m][n]=0;
			if(day==0){
				dp[d][0][0][0][0][0][h(1,1)]=satisfied(field,1,1);
			}else{
				REP(i,9){
					REP(j,9){
						REP(k,9){
							REP(l,9){
								REP(m,9){
									REP(n,9){
										if(dp[(d+1)%2][i][j][k][l][m][n]){
											int py=n/3,px=n%3;
											REP(o,9){
												int cy=o/3,cx=o%3;
												if(cy==py||cx==px){
													if(day>=6){
														vi pos;
														pos.push_back(i);
														pos.push_back(j);
														pos.push_back(k);
														pos.push_back(l);
														pos.push_back(m);
														pos.push_back(n);
														pos.push_back(o);
														if(thirsty(pos))continue;
													}
													dp[d][j][k][l][m][n][o]|=satisfied(field,cy,cx);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			d=(d+1)%2;
		}
		bool ok=false;
		REP(i,9){
			REP(j,9){
				REP(k,9){
					REP(l,9){
						REP(m,9){
							REP(n,9){
								ok|=dp[(d+1)%2][i][j][k][l][m][n];
							}
						}
					}
				}
			}
		}
		cout<<ok<<endl;
	}
}