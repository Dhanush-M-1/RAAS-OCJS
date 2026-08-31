#include<bits/stdc++.h>
using namespace std;
int a,b,c,d,n;
char s[10];
int main(){
	cin>>n;
	while(n--){
		cin>>s;
		if(s[0]=='A')a++;
		else if(s[0]=='W')b++;
		else if(s[0]=='T')c++;
		else d++;
	}
	printf("AC x %d\n",a);
	printf("WA x %d\n",b);
	printf("TLE x %d\n",c);
	printf("RE x %d\n",d);
} 