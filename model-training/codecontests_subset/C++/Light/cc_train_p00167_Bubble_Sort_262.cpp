#include <iostream>
#include <iomanip>
#include <sstream>
#include <stdio.h>
#include <vector>
#include <stack>
#include <queue>
#include <algorithm>
#include <math.h>
#include <utility>
#include <string>
#include <ctype.h>
#include <cstring>
#include <cstdio>
#include <sstream>
#include <functional>

using namespace std;

#define FOR(i,k,n) for(int i = (k); i < (n); i++)
#define REP(i,n) FOR(i,0,n)
#define INF 114514810
#define ll long long
//#define scanf scanf_s

int main()
{
	int n, a[1005];
	while (1)
	{
		cin >> n; if (n == 0)return 0;
		REP(i, n)cin >> a[i];
		int cnt = 0;
		REP(i, n-1)REP(j, n-1)
		{
			if (a[j] > a[j + 1])
			{
				swap(a[j], a[j + 1]);
				cnt++;
			}
		}
		cout << cnt << endl;

	}
	return 0;

}