#include<cstdio>
int n,a,b,c,d;
char str[20];
int main() {
	scanf("%d",&n);
	for (int i=1;i<=n;++i) {
		scanf("%s",&str);
		if (str[0]=='A') ++a;
		if (str[0]=='W') ++b;
		if (str[0]=='T') ++c;
		if (str[0]=='R') ++d;
	}
	printf("AC x %d\nWA x %d\nTLE x %d\nRE x %d\n",a,b,c,d);
	
	return 0;
} 