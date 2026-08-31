#include <cstdio>
#include <cstring>
#include <vector>
#include <algorithm>
using namespace std;

const int mod = 10000;
char const *limit;
int maxk, cut;
int memo[10][512][512][4];

inline int idx(bool up, bool down, bool high)
{
	return ((up << 1) | (down << 0));
}

int search(int n, int k, int p, bool up, bool down, bool high)
{
	int sum = 0;
	
	if(k >= (maxk - 1))
		return p == 0;
		
	if(!high && memo[n][k][p][idx(up, down, high)] != -1)
		return memo[n][k][p][idx(up, down, high)];
	
	for(int i = 0; i < 10; ++i) {
		
		if((n < i && !up) || (n == i) || (n > i && !down))
			continue;
			
		char c = limit[k + 1] - '0';
			
		if(high && c < i)
			continue;
			
		bool nexthigh = high && (c == i);
		
		sum += search(i, k + 1, (p * 10 + i) % cut, n > i, n < i, nexthigh);
	}
	
	sum = sum % mod;
	if(!high)
		memo[n][k][p][idx(up, down, high)] = sum;
	
	return sum;
}

int search(char *str, int law)
{
	int sum = 0;
	int len = strlen(str);
	bool start = false;
	
	memset(memo[0][0][0], -1, 10 * 512 * 512 * 4 * sizeof(int));
	
	maxk = len;
	cut = law;
	limit = str;
	
	for(int i = 0; i < maxk; ++i) {
		
		char c = limit[i] - '0';
		
		if(!start && c == 0)
			continue;
			
		for(int j = 1; j < 10; ++j) {
			
			if(!start && c < j)
				continue;
				
			bool nexthigh = !start && (c == j);
				
			sum += search(j, i, j % cut, true, true, nexthigh);
		}
		
		start = true;
		
		sum = sum % mod;
	}
	
	return sum;
}

int judge(char *str, int law)
{
	int len = strlen(str);
	bool start = false;
	int p = 0;
	bool up;
	
	for(int i = 0; (i < (len - 1)) && (p != -1); ++i) {
		
		char c1 = str[i] - '0', c2 = str[i + 1] - '0';
		
		if(!start && c1 == 0)
			continue;
			
		p = (p * 10 + c1) % law;
			
		if(start) {
			
			if(up && c1 >= c2)
				p = -1;
			if(!up && c1 <= c2)
				p = -1;
			up = !up;
		} else {
			
			if(c1 == c2)
				p = -1;
			else
				up = c1 > c2;
		}
			
		start = true;
	}
	
	if(p != -1)
		p = (p * 10 + (str[len - 1] - '0')) % law;
	
	return p == 0;
}

int main()
{
	char a[512] = "00", b[512] = "00";
	int m;
	
	scanf("%s%s%d", a + 2, b + 2, &m);
	
	int na, nb, ea;
	
	na = search(a, m);
	nb = search(b, m);
	ea = judge(a, m);
	
	int ans = (nb - na + ea + 5 * mod) % mod;
	
	//printf("%d - %d + %d = %d\n", nb, na, ea, ans);
	printf("%d\n", ans);
	
	return 0;
}