#include <algorithm>
#include <cstdio>
#define calc(l, r, t) std::min(l, std::max(r, t))
int seq[100005]; 
int main()
{
	// freopen("ARC082-F.in", "r", stdin);
	int x, n; 
	scanf("%d%d", &x, &n); 
	for (int i = 0; i < n; i++)
		scanf("%d", seq + i); 
	int q, idx = 0, coef = -1, l = x, r = 0, c = 0; 
	scanf("%d", &q); 
	while (q--)
	{
		int t, a; 
		scanf("%d%d", &t, &a); 
		while (idx < n && t >= seq[idx])
		{
			int dt = coef * (seq[idx] - (idx ? seq[idx - 1] : 0)); 
			l = calc(x, 0, l + dt); 
			r = calc(x, 0, r + dt); 
			c += dt; 
			idx++; 
			coef *= -1; 
		}
		int dt = coef * (t - (idx ? seq[idx - 1] : 0)); 
		printf("%d\n", calc(x, 0, calc(l, r, a + c) + dt));
	}
	return 0; 
}
