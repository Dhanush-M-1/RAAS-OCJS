#include <cstdio>
#include <string>
using namespace std;
int n;
void dfs(string s,int max){
	if(s.size()==n){
		printf("%s\n",s.c_str());
		return;
	}
	for(int i=97;i<=max;++i){
		dfs(s+char(i),max);
	}
	dfs(s+char(max+1),max+1);
}
int main(){
	scanf("%d",&n);
	dfs("a",97);
	return 0;
}
