#include<iostream>

using namespace std;
long long gcd(long long a, long long b){
	if(b==0){
		return a;
	}
	return gcd(b,a%b);
}

int main(){
	long long t,a,b,c,d,i;
	cin >> t;
	for(i=0;i<t;i++){
		cin >> a >> b >> c >> d;
		if(a<b){
			cout << "No" << endl;
			continue;
		}else if(d>=b && c>=b){
			cout << "Yes" << endl;
			continue;
		}
		if(b>d){
			cout << "No" << endl;
			continue;
		}
		long long x = a-b,y = a-c,z = gcd(b,d);
		if(((y-1)/z)*z>x){
			cout << "No" << endl;
		}else{
			cout << "Yes" << endl;
		}
	}
}