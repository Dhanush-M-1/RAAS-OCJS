#include<bits/stdc++.h>
using namespace std;
int n;
string s="a";

void dfs(char a){
	char c;
	
    if(s.size()==n){
		cout<<s<<endl;
		return;
	}
	
    for(c='a';c<=char(a+1);c++){
        s+=c;
        dfs(max(c,a));
        s.erase(s.end()-1);
    }
}

int main(){
    cin>>n;
    dfs('a');
    return 0;
}