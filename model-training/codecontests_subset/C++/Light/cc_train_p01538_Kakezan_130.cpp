#include <iostream>
#include <string>
using namespace std;

int main(){
	int q,n,count,a,b,res;
	string s,s1,s2;

	cin >> q;
	for(int i = 0;i < q;i++){
		cin >> n;
		count = 0;
		while(1){
			res = 0;
			if(n/10 == 0)break;
			s = to_string(n);
			for(int j = 1;j < s.size();j++){
				s1.assign(s,0,j);
				s2.assign(s,j,s.size()-j);
				a = stoi(s1);
				b = stoi(s2);
				res = max(res,a*b);
			}
			n = res;
			count++;
		}
		cout << count << endl;
	}

	return 0;
}