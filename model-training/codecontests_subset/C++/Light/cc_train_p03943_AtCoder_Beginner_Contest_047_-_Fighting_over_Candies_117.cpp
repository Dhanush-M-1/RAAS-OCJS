#include <iostream>
#include <algorithm>
int main(){int a,b,c,d;std::cin>>a>>b>>c;d=std::max({a,b,c});std::cout<<(a+b+c-d==d?"Yes":"No");}