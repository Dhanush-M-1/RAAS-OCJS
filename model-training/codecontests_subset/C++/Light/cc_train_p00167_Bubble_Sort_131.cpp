#include <cstdio>
#include <cstring>
#include <algorithm>
#include <string>
#include <cmath>
#include <stack>
#include <vector>
#include <map>
#include <set>
#include <queue>
#include <list>
#include <iostream>
#include <sstream>
#include <climits>
#include <cfloat>
#include <complex>

using namespace std;

int main()
{
	int n;
	while (scanf("%d", &n), n)
	{
		int arr[100];
		for (int i = 0; i < n; ++i)
			scanf("%d", arr+i);

		int ans = 0;
		for (int i = n-1; i > 0; --i)
		{
			for (int j = 0; j < i; ++j)
			{
				if (arr[j] > arr[j+1])
				{
					swap(arr[j], arr[j+1]);
					++ans;
				}
			}
		}
		printf("%d\n", ans);
	}

	return 0;
}