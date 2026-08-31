#include<iostream>
using namespace std;
int n;
int dif=0;
char s[1010];
void dfs(int i){
	if(i==n+1){
		cout<<s+1<<endl;
		return ;
	}
	for(int j=0;j<=dif;j++){
		s[i]='a'+j;
		int temp=dif;
		if(j==dif){
			dif++;
		}
		dfs(i+1);
		dif=temp;
	}
}
int main(){
	cin>>n;
	dfs(1);
	return 0;
} 