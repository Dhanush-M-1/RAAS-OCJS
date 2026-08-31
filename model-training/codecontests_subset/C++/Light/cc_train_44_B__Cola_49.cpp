/* 2013-08-11 08:59:57.373420 */#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <ctime>
#include <cmath>
#include <iostream>
#include <algorithm>

using namespace std;

int n, A, B, C;

int main(){
	//freopen("b.in", "r", stdin);
	scanf("%d%d%d%d", &n, &A, &B, &C);
	int ans = 0;
	for (int i = 0; i <= A; i++)
		for (int j = 0; j <= B; j++)
		{
			int Left = 2 * n - i - 2 * j;
			if (Left % 4) continue;
			Left /= 4;
			if (Left >= 0 && Left <= C) ++ans;
		}
	printf("%d\n", ans);
}