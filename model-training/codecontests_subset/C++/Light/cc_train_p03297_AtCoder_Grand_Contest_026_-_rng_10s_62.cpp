#include <cstdio>

typedef long long int64;

int64 gcd(const int64 x, const int64 y) { return y ? gcd(y, x % y) : x; }

int main() {
	int T;
	int64 A, B, C, D, g;
	
	scanf("%d", &T);
	while(T) {
		T--;
		scanf("%lld %lld %lld %lld", &A, &B, &C, &D);
		if(B > A or B > D)
			printf("No\n");
		else if(C >= B)
			printf("Yes\n");
		else {
			g = gcd(B, D);
			if(B - g + A % B % g > C)
				printf("No\n");
			else
				printf("Yes\n");
		}
	}
	return 0;
}