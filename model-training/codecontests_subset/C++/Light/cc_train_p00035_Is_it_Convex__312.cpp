#include <cstdio>
#include <vector>
#include <algorithm>
#include <cstring>
#include <string>
#include <cctype>
#include <sstream>
#include <cmath>
#include <climits>
#include <map>

using namespace std;

#define reep(i,f,n) for(int i=f; i<int(n); ++i)
#define rep(i,n) reep(i,0,n)

typedef vector<int> vi;

int main()
{
	double x[4], y[4];
	while(1){
		rep(i, 4){
			if(scanf("%lf,%lf,", &x[i], &y[i]) == EOF)
				return 0;
		}

		bool ok = true;
		bool turn = true;
		rep(i, 4){
			bool b = (x[(i+1)%4]-x[i])*(y[(i+2)%4]-y[i])-(y[(i+1)%4]-y[i])*(x[(i+2)%4]-x[i]) < 0.0;
			if(!i) turn = b;
			else if(turn^b){
				ok = false;
				break;
			}
		}
		puts(ok ? "YES" : "NO");
	}
}