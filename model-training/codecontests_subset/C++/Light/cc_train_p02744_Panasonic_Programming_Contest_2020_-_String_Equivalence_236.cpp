#include <cstdio>
#include <string>
using namespace std;
int n; 
void dfs(string s,int now){
	if(s.size()==n){
		printf("%s\n",s.c_str());
		return;
	}
	for(int i=1;i<now;++i){
		dfs(s+char(i+'a'-1),now);
	}
	dfs(s+char(now+'a'-1),now+1);
}
int main(){
	scanf("%d",&n);
	dfs("",1); 
	return 0;
}
