#include <bits/stdc++.h>
using namespace std;

char str[15];
int n;

void track(int ind,char maxi) {
	if (ind==n-1) {
		printf("%s\n",str);
		return;
	}
	for(char i='a';i<=maxi+1;i++) {
		str[ind+1]=i;
		track(ind+1,max(maxi,i));
	}
}

int main(void) {
	scanf("%d",&n);
	str[0]='a';
	track(0,'a');
}