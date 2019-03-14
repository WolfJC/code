package com.wolfjc.code.generator.generator;


import com.wolfjc.code.generator.table.TableInfo;

import java.util.Collection;

public interface CodeGenerator {

    void generateCode(Collection<TableInfo> tableInfoList);
}
