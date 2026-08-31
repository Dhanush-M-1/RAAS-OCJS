#include<iostream>
#include<string>
#include<string.h>
#include<algorithm>
#include<stdio.h>
#include<cmath>
#include<vector>
#include<utility>
#include<stack>
#include<queue>
#include<list>
#include<bitset>
#include<functional>

#define FOR(i, a, b) for(long long int i=(a);i<=(b);i++)
#define RFOR(i, a, b) for(long long int i=(a);i>=(b);i--)
#define MOD 1000000007
#define INF 1000000000 //2000000000
#define LLINF 1000000000000000000 //9000000000000000000
#define PI 3.14159265358979

using namespace std;
typedef long long int ll;
typedef pair< long long int, long long  int> P;



int main(void) {
	int n;
	int a[1001];
	bool flag = false;

	cin >> n;
	FOR(i, 1, n) {
		cin >> a[i];
	}
	FOR(i, 1, n) {
		FOR(t, i + 1, n) {
			if (abs(a[i] - a[t]) % (n - 1) == 0) {
				cout << a[i] << " " << a[t] << endl;
				flag = true;
			}
			if (flag) {
				break;
			}
		}
		if (flag) {
			break;
		}
	}


	return 0;
}
