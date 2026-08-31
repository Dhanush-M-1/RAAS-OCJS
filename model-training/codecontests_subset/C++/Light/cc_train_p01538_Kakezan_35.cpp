#include <string>
#include <cstdio>
#include <cstdlib>
char S[9];
int main(){
	int q,n,r,i;
	for(scanf("%d",&q);q--;printf("%d\n",r))
		for(r=0,scanf("%d",&n);n>9;r++){
			sprintf(S,"%d",n);n=0;
			std::string s=S;
			for(i=1;i<s.length();i++)n=std::max(n,atoi(s.substr(0,i).c_str())*atoi(s.substr(i).c_str()));
		}
}