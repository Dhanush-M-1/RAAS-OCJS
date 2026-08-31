#include <vector>
#include <algorithm>
#include <string>
#include <map>
#include <set>
#include <queue>
#include <cstring>
#include <deque>
#include <cstdio>
#include <cmath>
#include <complex>
#include <iostream>
#include <iterator>

using namespace std;

#define reep(i,f,t) for(int i=f ; i<int(t) ; ++i)
#define rep(i,n) reep(i, 0, n) 

typedef vector<int> vi;
typedef vector<vi> vvi;
typedef pair<int,int> pii;

const double EPS = 1e-8;

int main()
{
	int n;
	while(scanf("%d", &n), n){
		vi data(n);
		rep(i, n)
			scanf("%d", &data[i]);
		
		int cnt = 0;
		rep(i, n-1){
			rep(j, n-i-1){
				if(data[j] > data[j+1]){
					swap(data[j], data[j+1]);
					++cnt;
				}
			}
		}
		
		printf("%d\n", cnt);
	}
	
	return 0;
}