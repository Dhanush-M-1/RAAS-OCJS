#include <cstdio>
#include <cstring>
#include <algorithm>
using namespace std;

char s[1024];

int Number(int l, int r)
{
	int n = 0;
	for (int i = l; i <= r; i++){
		n = n * 10 + s[i] - '0';
	}
	
	return (n);
}

int main()
{
	int N;
	scanf("%d", &N);
	
	for (int c = 0; c < N; c++){
		scanf("%s", s);
		
		int cnt = 0;
		while (s[1] != '\0'){
			int ma = 0;
			
			int len = strlen(s);
			for (int m = 0; m < len - 1; m++){
				ma = max(ma, Number(0, m) * Number(m + 1, len - 1));
			}
			
			sprintf(s, "%d", ma);
			
			cnt++;
		}
		
		printf("%d\n", cnt);
	}
	
	return 0;
}