#include<bits/stdc++.h>
using namespace std;

long n;
char c[20];

void print(long l,char had) {
	if(l>n) {
		for(long i=1;i<=n;++i)
			putchar(c[i]);
		putchar('\n');
		return;
	}
	for(char i='a';i<had;i++) {
		c[l]=i;
		print(l+1,had);
	}
	c[l]=had;
	print(l+1,had+1);
}

int main() {
	cin>>n;
	print(1,'a');
	return 0;
}