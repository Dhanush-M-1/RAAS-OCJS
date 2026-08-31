#include <iostream>
using namespace std;
int N;
char str[11];
void dfs(int idx, char to){
	if(idx == N)
		cout << str << endl;
	else
		for(char c='a'; c<=to; c++){
			str[idx] = c;
			dfs(idx+1, max((int)to, c+1));
		}
}
int main(){
	cin >> N;
	dfs(0, 'a');
}
