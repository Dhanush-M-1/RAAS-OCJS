#include "bits/stdc++.h"
#define in std::cin
#define out std::cout
#define rep(i,N) for(int i=0;i<N;++i)
typedef long long int LL;

int N;
std::vector<int>a;

int main()
{
	in >> N;
	a.resize(N);
	rep(i, N) in >> a[i];
	rep(i, N)
	{
		rep(j, N)
		{
			if (i != j && abs(a[i] - a[j]) % (N - 1) == 0)
			{
				out << a[i] << " " << a[j] << std::endl;
				return 0;
			}
		}
	}
	return 0;
}

